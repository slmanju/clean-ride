package com.slmanju.core.entities;

import com.slmanju.core.values.Id;
import com.slmanju.core.values.RideLocation;
import com.slmanju.core.values.RideStatus;
import com.slmanju.core.values.VehicleType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public final class Ride {

  private Id id;
  private Id passengerId;
  private Id driverId;
  private RideLocation fromLocation;
  private RideLocation toLocation;
  private RideStatus status;
  private VehicleType vehicleType;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;

  public void accept(Id driverId) {
    this.driverId = driverId;
    this.status = RideStatus.ACCEPTED;
  }

  public void start() {
    this.status = RideStatus.STARTED;
    this.startDateTime = LocalDateTime.now();
  }

  public void complete() {
    this.status = RideStatus.COMPLETED;
    endDateTime = LocalDateTime.now();
  }

  public void cancel() {
    this.status = RideStatus.CANCELLED;
  }

}
