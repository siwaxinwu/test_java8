package org.roy.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2022/1/26 10:58
 */
public class NetUtils {
    private static final Logger LOG = LoggerFactory.getLogger(NetUtils.class);
    public static final String LOCALHOST = "127.0.0.1";
    public static final String ANYHOST = "0.0.0.0";
    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");
    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("192.168(\\.\\d{1,3}){2}$");
    private static volatile InetAddress LOCAL_ADDRESS = null;

    public NetUtils() {
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("192.168(\\.\\d{1,3}){2}+$");
        String s0 = "192.168.0.123";
        String s1 = "192.169.0.123";
        String s2 = "192.168.11.123";
        String s3 = "192.168.110.123";
        String s4 = "192.168.0.12";
        String s5 = "172.168.0.12";
        System.out.println(pattern.matcher(s0).matches());
        System.out.println(pattern.matcher(s1).matches());
        System.out.println(pattern.matcher(s2).matches());
        System.out.println(pattern.matcher(s3).matches());
        System.out.println(pattern.matcher(s4).matches());
        System.out.println(pattern.matcher(s5).matches());
        getLocalAddress();
    }

    private static boolean isValidAddress(InetAddress address) {
        if (address != null && !address.isLoopbackAddress()) {
            String name = address.getHostAddress();
            return name != null && !"0.0.0.0".equals(name) && !"127.0.0.1".equals(name) && IP_PATTERN.matcher(name).matches() && LOCAL_IP_PATTERN.matcher(name).matches();
        } else {
            return false;
        }
    }

    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;

        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable var6) {
            LOG.warn("Failed to retriving ip address, " + var6.getMessage(), var6);
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while(interfaces.hasMoreElements()) {
                    try {
                        NetworkInterface network = (NetworkInterface)interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        if (addresses != null) {
                            while(addresses.hasMoreElements()) {
                                try {
                                    InetAddress address = (InetAddress)addresses.nextElement();
                                    if (isValidAddress(address)) {
                                        return address;
                                    }
                                } catch (Throwable var5) {
                                    LOG.warn("Failed to retriving ip address, " + var5.getMessage(), var5);
                                }
                            }
                        }
                    } catch (Throwable var7) {
                        LOG.warn("Failed to retriving ip address, " + var7.getMessage(), var7);
                    }
                }
            }
        } catch (Throwable var8) {
            LOG.warn("Failed to retriving ip address, " + var8.getMessage(), var8);
        }

        LOG.error("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }

    public static String getHostName(String address) {
        try {
            int i = address.indexOf(58);
            if (i > -1) {
                address = address.substring(0, i);
            }

            InetAddress inetAddress = InetAddress.getByName(address);
            if (inetAddress != null) {
                String hostname = inetAddress.getHostName();
                return hostname;
            }
        } catch (Throwable var4) {
        }

        return address;
    }

    public static String getLocalHost() {
        String host = null;

        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            host = address.getHostName();
            if (host == null) {
                host = address.getHostName();
            }
        } catch (UnknownHostException var2) {
        }

        if (host == null) {
            address = getLocalAddress();
            host = address.getHostName();
            if (host == null) {
                host = address.getHostName();
            }
        }

        return host;
    }

    public static String getLocalIp() {
        String host = null;

        InetAddress address;
        try {
            //xmlydeMacBook-Pro.local/192.168.105.177
            address = InetAddress.getLocalHost();
            //192.168.105.177
            host = address.getHostAddress();
        } catch (UnknownHostException var2) {
        }

        if (host == null) {
            address = getLocalAddress();
            host = address == null ? "127.0.0.1" : address.getHostAddress();
        }

        return host;
    }

    public static InetAddress getLocalAddress() {
        if (LOCAL_ADDRESS != null) {
            return LOCAL_ADDRESS;
        } else {
            InetAddress localAddress = getLocalAddress0();
            LOCAL_ADDRESS = localAddress;
            return localAddress;
        }
    }
}
