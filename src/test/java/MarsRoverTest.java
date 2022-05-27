import org.ben.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {

    Rover rover;

    @BeforeEach
    void setup() {
        rover = new Rover(0,0,"N");
    }

    @Test
    @DisplayName("Should return a generated 10x10 matrix grid")
    void shouldReturnAGenerated10x10Grid() {
        Grid grid = new Grid();
        String[][] gridInstance = grid.generate();
        assertArrayEquals(gridInstance, grid.generate());
    }

    @Test
    @DisplayName("Should give the mars rover an X Y Co-ordinate")
    void shouldGiveTheMarsRoverAnXYCoOrdinate() {
        assertEquals("0:0:N", rover.position());
    }

    @ParameterizedTest
    @CsvSource({"M,0:1:N","MM,0:2:N","MMMMMMMMMM,0:10:N","MMMMMMMMMMM,0:0:N","MMMMMMMMMMMM,0:1:N",})
    void ShouldMoveTheRoverForwardOnDirectionOfTheGrid(String executedCommand, String expectedPosition){
        rover.execute(executedCommand);
        assertEquals(expectedPosition,rover.position());
    }
    @ParameterizedTest
    @CsvSource({"RM,1:0:E"})
    void ShouldRotateRightAndThenMoveTheRoverForwardWithTheExpectedAmount(String executedCommand, String expectedPosition){
        rover.execute(executedCommand);
        assertEquals(expectedPosition,rover.position());
    }

    @ParameterizedTest
    @CsvSource({"R,0:0:E","RR,0:0:S","RRR,0:0:W","RRRR,0:0:N"})
    void ShouldTurnTheRoverRightWithExpectedRoverPosition(String executedCommand, String expectedPosition){
        rover.execute(executedCommand);
        assertEquals(expectedPosition,rover.position());
    }
    @ParameterizedTest
    @CsvSource({"L,0:0:W","LL,0:0:S","LLL,0:0:E","LLLL,0:0:N"})
    void ShouldTurnTheRoverLeftWithExpectedRoverPosition(String executedCommand, String expectedPosition){
        rover.execute(executedCommand);
        assertEquals(expectedPosition,rover.position());
    }


}
