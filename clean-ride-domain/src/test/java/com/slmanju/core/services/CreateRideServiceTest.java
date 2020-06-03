package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.core.values.Id;
import com.slmanju.core.values.RideLocation;
import com.slmanju.core.values.RideStatus;
import com.slmanju.core.values.VehicleType;
import com.slmanju.ride.ports.in.CreateRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateRideServiceTest {

  @Test
  public void testWhenValidRide_save() {
    SaveRidePort saveRidePort = Mockito.mock(SaveRidePort.class);
    CreateRidePort createRidePort = new CreateRideService(saveRidePort);

    ArgumentCaptor<Ride> rideCaptor = ArgumentCaptor.forClass(Ride.class);

    CreateRidePort.CreateRideRequest createRideRequest = CreateRidePort.CreateRideRequest.builder()
        .fromLocation(new RideLocation())
        .toLocation(new RideLocation())
        .passengerId(Id.of(1L))
        .vehicleType(VehicleType.MINI)
        .build();

    createRidePort.createRide(createRideRequest);

    Mockito.verify(saveRidePort, Mockito.times(1)).saveRide(rideCaptor.capture());

    Ride rideCaptorValue = rideCaptor.getValue();
    Assertions.assertEquals(1L, rideCaptorValue.getPassengerId().getId());
    Assertions.assertEquals(VehicleType.MINI, rideCaptorValue.getVehicleType());
    Assertions.assertEquals(RideStatus.PENDING, rideCaptorValue.getStatus());
  }
}
