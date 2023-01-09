/********************************************************************************
 * Copyright (c) 2003-2015 John Green
 * Copyright (c) 2015-2023 Riverside Software
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
import org.prorefactor.treeparser.ContextQualifier;
import org.prorefactor.treeparser.symbols.Symbol;
import org.prorefactor.treeparser.symbols.TableBuffer;

import com.google.common.base.Strings;

public class RecordNameNode extends JPNode {
  private String sortAccess = "";
  private boolean wholeIndex;
  private String searchIndexName = "";
  private ContextQualifier qualifier;
  private int storeType;
  private boolean abbrev;

  public RecordNameNode(ProToken t, JPNode parent, int num, boolean hasChildren) {
    super(t, parent, num, hasChildren);
  }

  public void setContextQualifier(ContextQualifier qualifier) {
    this.qualifier = qualifier;
  }

  public ContextQualifier getQualifier() {
    return qualifier;
  }

  public String getSortAccess() {
    return sortAccess;
  }

  public boolean isWholeIndex() {
    return wholeIndex;
  }

  public String getSearchIndexName() {
    return searchIndexName;
  }

  public void setSortAccess(String str) {
    if (Strings.isNullOrEmpty(str))
      return;
    sortAccess = sortAccess + (sortAccess.isEmpty() ? "" : ',') + str;
  }

  public void setWholeIndex(boolean wholeIndex) {
    this.wholeIndex = wholeIndex;
  }

  public void setSearchIndexName(String indexName) {
    this.searchIndexName = indexName;
  }

  public int getStoreType() {
    return storeType;
  }

  public void setStoreType(int storeType) {
    this.storeType = storeType;
  }

  public void setAbbrev(boolean abbrev) {
    this.abbrev = abbrev;
  }

  @Override
  public boolean isAbbreviated() {
    return abbrev;
  }

  @Override
  public void setTableBuffer(TableBuffer buffer) {
    setSymbol(buffer);
  }

  @Override
  public TableBuffer getTableBuffer() {
    Symbol symbol = getSymbol();
    return symbol instanceof TableBuffer ? (TableBuffer) symbol : null;
  }

  @Override
  public boolean hasTableBuffer() {
    return getSymbol() instanceof TableBuffer;
  }

}
