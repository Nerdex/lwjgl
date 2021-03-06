/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opengles;

import org.lwjgl.util.generator.*;
import org.lwjgl.util.generator.opengl.GLenum;
import org.lwjgl.util.generator.opengl.GLreturn;
import org.lwjgl.util.generator.opengl.GLuint;

import java.nio.IntBuffer;

public interface EXT_multiview_draw_buffers {

	/** Accepted by the &lt;location&gt; parameter of DrawBuffersIndexedEXT: */
	int GL_COLOR_ATTACHMENT_EXT = 0x90F0,
		GL_MULTIVIEW_EXT        = 0x90F1;

	/** Accepted by the &lt;target&gt; parameter of GetIntegeri_EXT: */
	int GL_DRAW_BUFFER_EXT = 0x0C01,
		GL_READ_BUFFER_EXT = 0x0C02;

	/** Accepted by the &lt;target&gt; parameter of GetInteger: */
	int GL_MAX_MULTIVIEW_BUFFERS_EXT = 0x90F2;

	void glReadBufferIndexedEXT(@GLenum int src, int index);

	void glDrawBuffersIndexedEXT(@AutoSize("indices") int n, @Check("indices.remaining()") @Const @GLenum IntBuffer location,
	                             @Const IntBuffer indices);

	@StripPostfix("data")
	void glGetIntegeri_vEXT(@GLenum int target, @GLuint int index, @OutParameter @Check("4") IntBuffer data);

	@Alternate("glGetIntegeri_vEXT")
	@GLreturn("data")
	@StripPostfix("data")
	void glGetIntegeri_vEXT2(@GLenum int value, @GLuint int index, @OutParameter IntBuffer data);

}