/*******************************************************************************
 * Copyright (c) 2013 Bert De Geyter (https://github.com/TheHolyWaffle).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Bert De Geyter (https://github.com/TheHolyWaffle) - initial API and implementation
 ******************************************************************************/
package com.github.theholywaffle.teamspeak3.api;

public enum CodecEncryptionMode {

	CODEC_CRYPT_INDIVIDUAL(0),
	CODEC_CRYPT_DISABLED(1),
	CODEC_CRYPT_ENABLED(2),
	UNKNOWN(-1);

	private int i;

	CodecEncryptionMode(int i) {
		this.i = i;
	}

	public int getIndex() {
		return i;
	}

}
