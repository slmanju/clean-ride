package com.slmanju.ride.ports.in;

import com.slmanju.core.values.Id;
import lombok.Builder;
import lombok.Getter;

public interface AcceptRidePort {

  void acceptRide(AcceptRideRequest acceptRideRequest);

  @Getter @Builder
  class AcceptRideRequest {
    private Id rideId;
    private Id driverId;
  }

}
