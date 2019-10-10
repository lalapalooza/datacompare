/* Version 1.0 based on Apache Software License 1.1
 *
 * Copyright (c) 2003 Piotr Maj and DBMonster developers. All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * 3. The end-user documentation included with the redistribution, if any,
 *    must include the following acknowledgment:
 *
 *    "This product includes software developed by DBMonster developers
 *    (http://dbmonster.kernelpanic.pl/)."
 *
 *  Alternately, this acknowledgment may appear in the software itself,
 *  if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The name "DBMonster" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact pm@jcake.com.
 *
 * 5. Products derived from this software may not be called "DBMonster",
 *    nor may "DBMonster" appear in their name, without prior written
 *    permission of Piotr Maj.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE DBMONSTER DEVELOPERS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.clinbrain.datac.common.schema;

/**
 * SchemaException is throws when an error occures in the
 * schema structure.
 *
 * @author Piotr Maj &lt;pm@jcake.com&gt;
 *
 * @version $Id: SchemaException.java,v 1.3 2006/01/05 16:29:37 majek Exp $
 */
public class SchemaException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs new SchemaException with a reason.
     *
     * @param message error message
     */
    public SchemaException(String message) {
        super(message);
    }
}
