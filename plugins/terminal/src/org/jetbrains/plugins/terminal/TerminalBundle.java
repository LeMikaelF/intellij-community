// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.plugins.terminal;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public final class TerminalBundle {
  private static final @NonNls String BUNDLE = "messages.TerminalBundle";
  private static final DynamicBundle INSTANCE = new DynamicBundle(TerminalBundle.class, BUNDLE);

  private TerminalBundle() { }

  @NotNull
  public static @Nls String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
    return INSTANCE.containsKey(key) ? INSTANCE.getMessage(key, params) : TerminalDeprecatedMessagesBundle.message(key, params);
  }

  @NotNull
  public static Supplier<@Nls String> messagePointer(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
    return INSTANCE.containsKey(key) ? INSTANCE.getLazyMessage(key, params) : TerminalDeprecatedMessagesBundle.messagePointer(key, params);
  }
}
