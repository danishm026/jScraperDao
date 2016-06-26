package com.arc.jScraperDao.fileio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileIOTest {
	@Mock
	private ArrayList<String> list;
	@Mock
	private Iterator<String> iterator;
	
	@Test
	public void writeListtoFileTest() {
		PrintWriter writer = mock(PrintWriter.class);
		
		when(list.iterator()).thenReturn(iterator);
		when(iterator.hasNext())
		.thenReturn(true)
		.thenReturn(true)
		.thenReturn(true)
		.thenReturn(false);
		
		when(iterator.next())
		.thenReturn("first")
		.thenReturn("second")
		.thenReturn("third");
		
		FileIO.writeListtoFile(list, writer);
		
		verify(list).iterator();
		
		verify(iterator, times(4)).hasNext();
		verify(iterator, times(3)).next();
		
		verify(writer).println("first");
		verify(writer).println("second");
		verify(writer).println("third");
	}
}
