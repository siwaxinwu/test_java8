package org.roy.songtest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.kevinsawicki.http.HttpRequest;
import org.junit.Test;


import java.util.Base64;
import java.util.Calendar;
import java.util.List;


public class Xmly10Test {

  /**
   * 分页获取歌曲
   *
   */
  @Test
  public void test1() {
    // 客户 ID
    final String customerKey = "1c0580c5eef84aac94fab04f8a961b54";
    // 客户密钥
    final String customerSecret = "4dc4ceb9e9e14e7197eba68ef86ad8e9";

    // 拼接客户 ID 和客户密钥并使用 base64 编码
    String plainCredentials = customerKey + ":" + customerSecret;
    String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
    // 创建 authorization header
    String authorizationHeader = "Basic " + base64Credentials;
    HttpRequest httpRequest = HttpRequest
            .get("https://api.agora.io/cn/v1.0/projects/448db38e93964281a773f7a713a02160/ktv-service/api/serv/songs?requestId=1000001&pageType=0&size=2")
            .header("Authorization", authorizationHeader)
            .header("Content-Type", "application/json");
    String body = httpRequest.body();
    SongRootResult<DataResult> songRootResult = JSON.parseObject(body, new TypeReference<SongRootResult<DataResult>>() {
    });
    DataResult data = songRootResult.getData();
    List<Song> list = data.getList();
    System.out.println(list);

    System.out.println(songRootResult);
  }

  /** 获取指定歌曲 */
  @Test
  public void test2() {
    // 客户 ID
    final String customerKey = "1c0580c5eef84aac94fab04f8a961b54";
    // 客户密钥
    final String customerSecret = "4dc4ceb9e9e14e7197eba68ef86ad8e9";

    // 拼接客户 ID 和客户密钥并使用 base64 编码
    String plainCredentials = customerKey + ":" + customerSecret;
    String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
    // 创建 authorization header
    String authorizationHeader = "Basic " + base64Credentials;
    HttpRequest httpRequest =
        HttpRequest.get(
                "https://api.agora.io/cn/v1.0/projects/448db38e93964281a773f7a713a02160/ktv-service/api/serv/song-url?requestId=1000001&songCode=6246262727281830&lyricType=0")
            .header("Authorization", authorizationHeader)
            .header("Content-Type", "application/json");
    String body = httpRequest.body();

    SongRootResult<OneSongResult> oneSongResult =
        JSON.parseObject(body, new TypeReference<SongRootResult<OneSongResult>>() {});
    OneSongResult data = oneSongResult.getData();
    System.out.println(data);
  }


  /**
   * 获取增量歌曲，每隔24H执行一次
   *
   */
  @Test
  public void test3() {
    // 客户 ID
    final String customerKey = "1c0580c5eef84aac94fab04f8a961b54";
    // 客户密钥
    final String customerSecret = "4dc4ceb9e9e14e7197eba68ef86ad8e9";

    // 拼接客户 ID 和客户密钥并使用 base64 编码
    String plainCredentials = customerKey + ":" + customerSecret;
    String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
    // 创建 authorization header
    String authorizationHeader = "Basic " + base64Credentials;
    HttpRequest httpRequest =
        HttpRequest.get(
                "https://api.agora.io/cn/v1.0/projects/448db38e93964281a773f7a713a02160/ktv-service/api/serv/songs-incr?requestId=1000001&lastUpdateTime=1641796996000")
            .header("Authorization", authorizationHeader)
            .header("Content-Type", "application/json");
    String body = httpRequest.body();
    SongRootResult<DataResult> oneSongResult =
            JSON.parseObject(body, new TypeReference<SongRootResult<DataResult>>() {});
    DataResult data = oneSongResult.getData();
    System.out.println(data);
  }

  /**
   * 热歌榜单
   *
   */
  @Test
  public void test4() {
    // 客户 ID
    final String customerKey = "1c0580c5eef84aac94fab04f8a961b54";
    // 客户密钥
    final String customerSecret = "4dc4ceb9e9e14e7197eba68ef86ad8e9";

    // 拼接客户 ID 和客户密钥并使用 base64 编码
    String plainCredentials = customerKey + ":" + customerSecret;
    String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
    // 创建 authorization header
    String authorizationHeader = "Basic " + base64Credentials;
    HttpRequest httpRequest =
            HttpRequest.get(
                    "https://api.agora.io/cn/v1.0/projects/448db38e93964281a773f7a713a02160/ktv-service/api/serv/song-hot?requestId=1000001&hotType=1")
                    .header("Authorization", authorizationHeader)
                    .header("Content-Type", "application/json");
    String body = httpRequest.body();
    SongRootResult<DataResult> oneSongResult =
            JSON.parseObject(body, new TypeReference<SongRootResult<DataResult>>() {});
    DataResult data = oneSongResult.getData();
    System.out.println(data);
  }

  @Test
  public void test5() {
    Long aLong = qrylastTwoTime();
    System.out.println(aLong);
  }


  private static Long qrylastTwoTime(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) - 1,2,00,00);
    return calendar.getTime().getTime();
  }



}
