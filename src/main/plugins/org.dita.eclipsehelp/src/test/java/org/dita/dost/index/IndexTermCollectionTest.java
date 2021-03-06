/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2017 Jarno Elovirta
 *
 *  See the accompanying LICENSE file for applicable license.
 */
package org.dita.dost.index;

import org.dita.dost.TestUtils;
import org.dita.dost.exception.DITAOTException;
import org.dita.dost.writer.EclipseIndexWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IndexTermCollectionTest {

    private File tempDir;

    @Before
    public void setUp() throws Exception {
        tempDir = TestUtils.createTempDir(getClass());
    }

    @Test
    public void testOutputTerms() throws DITAOTException {
        final IndexTermCollection i = new IndexTermCollection();
        i.setIndexClass(EclipseIndexWriter.class.getCanonicalName());
        i.setOutputFileRoot(new File(tempDir, "foo").getAbsolutePath());
        final IndexTerm first = new IndexTerm();
        first.setTermName("first");
        first.setTermKey("first");
        final IndexTerm second = new IndexTerm();
        second.setTermName("second");
        second.setTermKey("second");
        i.addTerm(second);
        i.addTerm(first);
        i.outputTerms();
    }

    @After
    public void tearDown() throws IOException {
        TestUtils.forceDelete(tempDir);
    }

}
