package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.ride.ports.in.StartRidePort;
import com.slmanju.ride.ports.out.FindRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StartRideService implements StartRidePort {

  private final SaveRidePort saveRidePort;
  private final FindRidePort findRidePort;

  @Override
  public void startRide(StartRideRequest startRideRequest) {
    Ride ride = findRidePort.findRide(startRideRequest.getRideId());
    ride.start();

    saveRidePort.saveRide(ride);
  }

}
