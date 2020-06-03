package com.slmanju.ride.ports.out;

import com.slmanju.core.entities.Ride;
import com.slmanju.core.values.Id;

public interface FindRidePort {

  Ride findRide(Id rideId);

}
