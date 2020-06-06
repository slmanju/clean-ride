package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.core.values.Id;
import com.slmanju.core.values.RideStatus;
import com.slmanju.core.values.VehicleType;
import com.slmanju.ride.ports.in.AcceptRidePort;
import com.slmanju.ride.ports.out.FindRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcceptRideServiceTest {

  @Test
  public void testWhenAccept_save() {
    SaveRidePort saveRidePort = mock(SaveRidePort.class);
    FindRidePort findRidePort = mock(FindRidePort.class);
    AcceptRidePort acceptRidePort = new AcceptRideService(saveRidePort, findRidePort);

    ArgumentCaptor<Ride> rideCaptor = ArgumentCaptor.forClass(Ride.class);

    Ride mockRide = Ride.builder().status(RideStatus.PENDING).passengerId(Id.of(3L)).vehicleType(VehicleType.PRO).build();
    when(findRidePort.findRide(any(Id.class))).thenReturn(mockRide);

    AcceptRidePort.AcceptRideRequest acceptRideRequest = AcceptRidePort.AcceptRideRequest.builder()
        .driverId(Id.of(5L))
        .rideId(Id.of(10L))
        .build();
    acceptRidePort.acceptRide(acceptRideRequest);

    verify(saveRidePort, times(1)).saveRide(rideCaptor.capture());

    Ride rideCaptorValue = rideCaptor.getValue();
    assertEquals(3L, rideCaptorValue.getPassengerId().getId());
    assertEquals(VehicleType.PRO, rideCaptorValue.getVehicleType());
    assertEquals(RideStatus.ACCEPTED, rideCaptorValue.getStatus());
  }
}
