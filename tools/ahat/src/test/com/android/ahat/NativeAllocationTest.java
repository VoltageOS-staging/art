/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.ahat;

import com.android.ahat.heapdump.AhatInstance;
import com.android.ahat.heapdump.AhatSnapshot;
import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NativeAllocationTest {

  @Test
  public void nativeAllocation() throws IOException {
    TestDump dump = TestDump.getTestDump();

    AhatSnapshot snapshot = dump.getAhatSnapshot();
    AhatInstance referent = dump.getDumpedAhatInstance("anObject");
    assertEquals(50000, referent.getSize().getRegisteredNativeSize());
  }

  @Test
  public void nativeAllocationCleaned() throws IOException {
    TestDump dump = TestDump.getTestDump();

    AhatInstance referent = dump.getDumpedAhatInstance("aCleanedObject");
    assertEquals(0, referent.getSize().getRegisteredNativeSize());
  }
}
