package com.slmanju.core.entities;

import com.slmanju.core.values.Id;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Passenger {

  private Id id;
  private String name;

}
