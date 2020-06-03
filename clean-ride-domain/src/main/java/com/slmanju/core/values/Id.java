package com.slmanju.core.values;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Id {

  private Long id;

  public static Id of(Long id) {
    return new Id(id);
  }

}
