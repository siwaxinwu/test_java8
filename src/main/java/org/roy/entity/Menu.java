package org.roy.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:09 2021-03-26
 */
@Data
@Builder
public class Menu {
  /** id */
  public Integer id;
  /** 名称 */
  public String name;
  /** 父id ，根节点为0 */
  public Integer parentId;
  /** 子节点信息 */
  public List<Menu> childList;

  public Menu(Integer id, String name, Integer parentId) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
  }

  public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
    this.childList = childList;
  }
}
