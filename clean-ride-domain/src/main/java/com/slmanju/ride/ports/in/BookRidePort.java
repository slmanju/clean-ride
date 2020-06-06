package com.slmanju.ride.ports.in;

import com.slmanju.core.values.Id;
import com.slmanju.core.values.RideLocation;
import com.slmanju.core.values.VehicleType;
import lombok.Builder;
import lombok.Getter;

public interface BookRidePort {

  void createRide(CreateRideRequest createRideRequest);

  @Getter @Builder
  class CreateRideRequest {
    private Id id;
    private Id passengerId;
    private RideLocation fromLocation;
    private RideLocation toLocation;
    private VehicleType vehicleType;
  }

}
