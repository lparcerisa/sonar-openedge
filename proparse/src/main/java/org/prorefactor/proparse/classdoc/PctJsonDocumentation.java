/********************************************************************************
 * Copyright (c) 2015-2022 Riverside Software
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
package org.prorefactor.proparse.classdoc;

import java.util.List;

import com.google.gson.annotations.SerializedName;

// JSON objects generated by JsonDocumentation task
// File contains an array of those objects.
public class PctJsonDocumentation {

  @SerializedName(value = "className")
  public String className;
  @SerializedName(value = "comments")
  public List<String> comments;
  @SerializedName(value = "deprecated")
  public Deprecated deprecated;

  @SerializedName(value = "methods")
  public List<Method> methods;
  @SerializedName(value = "constructors")
  public List<Method> constructors;
  @SerializedName(value = "properties")
  public List<Property> properties;

  public class Property {
    @SerializedName(value = "name")
    public String name;
    @SerializedName(value = "type")
    public String type;
    @SerializedName(value = "comments")
    public List<String> comments;
    @SerializedName(value = "deprecated")
    public Deprecated deprecated;
  }

  public class Method {
    @SerializedName(value = "name")
    public String name;
    @SerializedName(value = "signature")
    public String signature;
    @SerializedName(value = "comments")
    public List<String> comments;
    @SerializedName(value = "deprecated")
    public Deprecated deprecated;
  }

  public class Parameter {
    @SerializedName(value = "name")
    public String name;
    @SerializedName(value = "modifier")
    public String modifier;
    @SerializedName(value = "type")
    public String type;
  }

  public class Deprecated {
    @SerializedName(value = "since") 
    public String since;
    @SerializedName(value = "message")
    public String message;
	}
}
