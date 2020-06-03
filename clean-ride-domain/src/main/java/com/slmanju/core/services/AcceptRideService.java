package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.ride.ports.in.AcceptRidePort;
import com.slmanju.ride.ports.out.FindRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AcceptRideService implements AcceptRidePort {

  private final SaveRidePort saveRidePort;
  private final FindRidePort findRidePort;

  @Override
  public void acceptRide(AcceptRideRequest acceptRideRequest) {
    Ride ride = findRidePort.findRide(acceptRideRequest.getRideId());
    ride.accept(acceptRideRequest.getDriverId());

    saveRidePort.saveRide(ride);
  }

}
