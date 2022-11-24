package com.conexasaude.usecases;

import com.conexasaude.entity.AttendanceEntity;
import com.conexasaude.entity.HealthProfessionalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttendanceServiceImplTest {

  final LocalDateTime dateOne = LocalDateTime.parse("2022-11-22T10:00:00");
  final LocalDateTime dateTwo = LocalDateTime.parse("2022-11-22T15:00:00");
  @Mock HealthProfessionalEntity professional = new HealthProfessionalEntity();
  @Mock Set<AttendanceEntity> attendanceList = new HashSet<>();
  @Mock AttendanceEntity attendanceOne = new AttendanceEntity();
  @Mock AttendanceEntity attendanceTwo = new AttendanceEntity();
  Set<LocalDateTime> attendanceDates = new HashSet<>();

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void givenAttendanceDatesCheckContainsDateTrue() {
    // GIVEN
    var date = LocalDateTime.parse("2022-11-22T15:00:00");

    // THEN
    getAttendanceDates();

    // ASSERT
    assertTrue(attendancesContainDate(professional.getId(), date));
  }

  @Test
  void givenAttendanceDatesCheckContainsDateFalse() {
    // GIVEN
    var date = LocalDateTime.parse("2022-11-22T08:00:00");

    // THEN
    getAttendanceDates();

    // ASSERT
    assertFalse(attendancesContainDate(professional.getId(), date));
  }

  private void getAttendanceDates() {
    Mockito.when(attendanceOne.getDate()).thenReturn(dateOne);
    Mockito.when(attendanceTwo.getDate()).thenReturn(dateTwo);
    attendanceList.addAll(List.of(attendanceOne, attendanceTwo));
    Mockito.when(professional.getAttendances()).thenReturn(attendanceList);
    attendanceDates.addAll(List.of(dateOne, dateTwo));
  }

  public boolean attendancesContainDate(Long professionalId, LocalDateTime attendanceDate) {
    return attendanceDates.contains(attendanceDate);
  }
}
