package com.slmanju.ride.ports.in;

import com.slmanju.core.values.Id;
import lombok.Builder;
import lombok.Getter;

public interface StartRidePort {

  void startRide(StartRideRequest startRideRequest);

  @Getter @Builder
  class StartRideRequest {
    private Id rideId;
  }

}
