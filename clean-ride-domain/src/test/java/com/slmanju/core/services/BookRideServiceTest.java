package com.slmanju.core.services;

import com.slmanju.core.entities.Ride;
import com.slmanju.core.values.Id;
import com.slmanju.core.values.RideLocation;
import com.slmanju.core.values.RideStatus;
import com.slmanju.core.values.VehicleType;
import com.slmanju.ride.ports.in.BookRidePort;
import com.slmanju.ride.ports.out.SaveRidePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookRideServiceTest {

  @Test
  public void testWhenValidRide_save() {
    SaveRidePort saveRidePort = mock(SaveRidePort.class);
    BookRidePort bookRidePort = new BookRideService(saveRidePort);

    ArgumentCaptor<Ride> rideCaptor = ArgumentCaptor.forClass(Ride.class);

    BookRidePort.CreateRideRequest createRideRequest = BookRidePort.CreateRideRequest.builder()
        .fromLocation(new RideLocation())
        .toLocation(new RideLocation())
        .passengerId(Id.of(1L))
        .vehicleType(VehicleType.MINI)
        .build();

    bookRidePort.createRide(createRideRequest);

    verify(saveRidePort, times(1)).saveRide(rideCaptor.capture());

    Ride rideCaptorValue = rideCaptor.getValue();
    assertEquals(1L, rideCaptorValue.getPassengerId().getId());
    assertEquals(VehicleType.MINI, rideCaptorValue.getVehicleType());
    assertEquals(RideStatus.PENDING, rideCaptorValue.getStatus());
  }
}
