package si_lab2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyBranchTest(){
        // 1
        int payment1 = 0;
        List<Item> list1 = null;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list1, payment1));
        // 2
        List<Item> list2 = new ArrayList<>();
        list2.add(new Item("bread", "123a", 30, 0.1f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list2, payment1));
        // 3
        List<Item> list3 = new ArrayList<>();
        list3.add(new Item("bread", null, 30, 0.1f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list3, payment1));
        // 4
        List<Item> list4 = new ArrayList<>();
        list4.add(new Item("", "1234", 30, 0.1f));
        SILab2.checkCart(list4, payment1);
        assertEquals("unknown", list4.get(0).getName());
        // 5
        int payment2 = 500;
        List<Item> list5 = new ArrayList<>();
        list5.add(new Item("bread", "1234", 30, 0));
        list5.add(new Item("milk", "5678", 100, 0));
        assertTrue(SILab2.checkCart(list5, payment2));
        // 6
        List<Item> list6 = new ArrayList<>();
        list6.add(new Item("bread", "1234", 30, 0));
        list6.add(new Item("milk", "5678", 100, 0));
        list6.add(new Item("avocado", "9101", 400, 0));
        assertFalse(SILab2.checkCart(list6, payment2));
        // 7
        List<Item> list7 = new ArrayList<>();
        list7.add(new Item("bread", "1234", 30, 0.1f));
        list7.add(new Item("milk", "5678", 100, 0.2f));
        assertTrue(SILab2.checkCart(list7, payment2));
        // 8
        List<Item> list8 = new ArrayList<>();
        list8.add(new Item("bread", "1234", 30, 0.9f));
        list8.add(new Item("milk", "5678", 100, 0.9f));
        list8.add(new Item("avocado", "9101", 500, 0.9f));
        assertFalse(SILab2.checkCart(list8, payment2));
    }

    @Test
    public void multipleConditionTest(){
        // 1
        List<Item> list1 = new ArrayList<>();
        list1.add(new Item("bread","0123", 300, 0.9f));
        assertFalse(SILab2.checkCart(list1,269));
        // 2
        List<Item> list2 = new ArrayList<>();
        list2.add(new Item("bread","0123",400,0));
        assertFalse(SILab2.checkCart(list2,370));
        // 3
        List<Item> list3 = new ArrayList<>();
        list3.add(new Item("bread","1234",400,0.9f));
        assertFalse(SILab2.checkCart(list3,359));
        // 4
        List<Item> list4 = new ArrayList<>();
        list4.add(new Item("bread","0123",400,0.9f));
        assertTrue(SILab2.checkCart(list4,330));
    }
}
