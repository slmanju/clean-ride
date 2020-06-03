package com.slmanju.core.entities;

import com.slmanju.core.values.Id;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Driver {

  private Id id;
  private String name;

}
