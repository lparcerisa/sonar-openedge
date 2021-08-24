/********************************************************************************
 * Copyright (c) 2015-2021 Riverside Software
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU Lesser General Public License v3.0
 * which is available at https://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * SPDX-License-Identifier: EPL-2.0 OR LGPL-3.0
 ********************************************************************************/
package org.prorefactor.core;

import java.util.ArrayList;
import java.util.List;

class JPNodeExpressionQuery implements ICallback<List<JPNode>> {
  private final List<JPNode> result = new ArrayList<>();

  @Override
  public List<JPNode> getResult() {
    return result;
  }

  @Override
  public boolean visitNode(JPNode node) {
    if (node.isExpression()) {
      result.add(node);
      return false;
    } else
      return true;
  }

}