package com.shahed.spring.junitmockitotest.practice.junitmockitotest.unittesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockTest {
    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private BusinessService businessService;

    @Test
    public void testFindTheGreatestFromAllData(){
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {13, 45, 3});
        assertEquals(45, businessService.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue(){
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {13});
        assertEquals(13, businessService.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_ForNoValues(){
        when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessService.findTheGreatestFromAllData());
    }
}
