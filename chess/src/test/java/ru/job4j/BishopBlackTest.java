package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPosition(){
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        assertThat(bishopBlack.position(),is(Cell.A3));
    }
    @Test
    public void whenCopy() {
        Figure figure = new BishopBlack(Cell.A3).copy(Cell.C6);
        assertThat(new BishopBlack(Cell.C6).position(), is(figure.position()));
    }

    @Test
    public void whenWay(){
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        assertThat(bishopBlack.way(Cell.G5,Cell.C1),is(new Cell[]{Cell.F4,Cell.E3,Cell.D2,Cell.C1}));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNoDiagonalWay(){
        new BishopBlack(Cell.C1).way(Cell.C1,Cell.D3);
    }

    @Test
    public void whenDiagonal(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1,Cell.G5),is(true));
    }
}
