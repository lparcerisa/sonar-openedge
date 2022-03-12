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
package org.prorefactor.core.nodetypes;

import org.prorefactor.core.JPNode;
import org.prorefactor.core.ProToken;

import com.google.common.base.Strings;

import eu.rssw.pct.elements.DataType;
import eu.rssw.pct.elements.IMethodElement;
import eu.rssw.pct.elements.ITypeInfo;

/**
 * Expression node: <code>methodName(parameters)</code> (only in classes)
 */
public class LocalMethodCallNode extends ExpressionNode implements IMethodCallExpression {
  private String methodName = "";
  private String xrefSig = "";
  private IMethodElement method;

  public LocalMethodCallNode(ProToken t, JPNode parent, int num, boolean hasChildren, String methodName) {
    super(t, parent, num, hasChildren);
    this.methodName = Strings.nullToEmpty(methodName);
  }

  @Override
  public String getMethodName() {
    return methodName;
  }

  @Override
  public void setXrefSig(String xrefSig) {
    this.xrefSig = xrefSig;
  }

  @Override
  public String getXrefSig() {
    return xrefSig;
  }

  public void setMethod(IMethodElement method) {
    this.method = method;
  }

  public IMethodElement getMethod() {
    return method;
  }

  @Override
  public DataType getDataType() {
    ProgramRootNode root = getTopLevelParent();
    ITypeInfo info = getCalleeTypeInfo();
    while (info != null) {
      for (IMethodElement elem : info.getMethods()) {
        if (elem.getName().equalsIgnoreCase(methodName))
          return elem.getReturnType();
      }
      info = root.getParserSupport().getProparseSession().getTypeInfo(info.getParentTypeName());
    }

    return DataType.NOT_COMPUTED;
  }

  @Override
  public DataType getLeftPart() {
    return new DataType(getCalleeTypeInfo().getTypeName());
  }

  private ITypeInfo getCalleeTypeInfo() {
    ProgramRootNode root = getTopLevelParent();
    if (root == null)
      return null;

    ITypeInfo info = root.getParserSupport().getProparseSession().getTypeInfo(root.getParserSupport().getClassName());
    if (info != null)
      return info;
    else 
      return root.getParserSupport().getProparseSession().getTypeInfo("Progress.Lang.Object");
  }

}
