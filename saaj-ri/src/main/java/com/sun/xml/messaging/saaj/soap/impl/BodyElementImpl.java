/*
 * Copyright (c) 1997, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.messaging.saaj.soap.impl;

import javax.xml.namespace.QName;

import com.sun.xml.messaging.saaj.util.LogDomainConstants;
import jakarta.xml.soap.*;

import com.sun.xml.messaging.saaj.soap.SOAPDocumentImpl;
import org.w3c.dom.Element;

import java.util.logging.Logger;

/**
 * All elements of the SOAP-ENV:BODY.
 *
 * @author Anil Vijendran (akv@eng.sun.com)
 */
public abstract class BodyElementImpl
    extends ElementImpl
    implements SOAPBodyElement {

    private static final Logger log = Logger.getLogger(LogDomainConstants.SOAP_IMPL_DOMAIN, "com.sun.xml.messaging.saaj.soap.impl.LocalStrings");

    protected BodyElementImpl(SOAPDocumentImpl ownerDoc, Name qname) {
        super(ownerDoc, qname);
    }

    protected BodyElementImpl(SOAPDocumentImpl ownerDoc, QName qname) {
        super(ownerDoc, qname);
    }

    protected BodyElementImpl(SOAPDocumentImpl ownerDoc, Element domElement) {
        super(ownerDoc, domElement);
    }

    @Override
    public void setParentElement(SOAPElement element) throws SOAPException {
        if (! (element instanceof SOAPBody)) {
            log.severe("SAAJ0101.impl.parent.of.body.elem.mustbe.body");
            throw new SOAPException("Parent of a SOAPBodyElement has to be a SOAPBody");
        }
        super.setParentElement(element);
    }


}
