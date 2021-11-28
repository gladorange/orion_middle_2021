package com.orion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestMockito {

    public static void main(String[] args) {
        final ArrayList<Object> mock = mock(ArrayList.class);

        doAnswer(invocation -> {
            System.out.println("Пытаемся добавить в лист " + invocation.getArguments()[0]);
            return null;
        }).when(mock).add(anyObject());

        mock.add(null);
        mock.add(null);
        mock.add(null);
        mock.add(null);
    }
}
