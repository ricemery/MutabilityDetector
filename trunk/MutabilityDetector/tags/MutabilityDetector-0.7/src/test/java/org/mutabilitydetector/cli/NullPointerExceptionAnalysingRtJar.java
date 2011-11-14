/*
 *    Copyright (c) 2008-2011 Graham Allan
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.mutabilitydetector.cli;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Ignore;
import org.junit.Test;

import com.google.classpath.ClassPathFactory;

public class NullPointerExceptionAnalysingRtJar {

    private final PrintStream errorStream = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) throws IOException {
            // suppress output in tests
        }
    });

    @Ignore
    @Test
    public void checkNullPointerExceptionIsNotThrown() {
        String rtJarPath = System.getProperty("java.home") + "/lib/rt.jar";
        BatchAnalysisOptions options = new CommandLineOptions(errorStream, "-cp", rtJarPath);
        new RunMutabilityDetector(new ClassPathFactory().createFromPath(rtJarPath), options).run();
    }
    
    @Ignore
    @Test
    public void checkNullPointerExceptionIsNotThrownOnAbritaryCodebase() {
        String rtJarPath = "...";
        BatchAnalysisOptions options = new CommandLineOptions(errorStream, "-cp", rtJarPath);
        new RunMutabilityDetector(new ClassPathFactory().createFromPath(rtJarPath), options).run();
    }

}