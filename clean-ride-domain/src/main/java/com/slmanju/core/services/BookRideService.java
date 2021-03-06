package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.core.values.RideStatus;
import com.slmanju.ride.ports.in.BookRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookRideService implements BookRidePort {

  private final SaveRidePort saveRidePort;

  @Override
  public void createRide(CreateRideRequest createRideRequest) {
    Ride ride = Ride.builder()
        .passengerId(createRideRequest.getPassengerId())
        .fromLocation(createRideRequest.getFromLocation())
        .toLocation(createRideRequest.getToLocation())
        .vehicleType(createRideRequest.getVehicleType())
        .status(RideStatus.PENDING)
        .build();

    saveRidePort.saveRide(ride);
  }

}
