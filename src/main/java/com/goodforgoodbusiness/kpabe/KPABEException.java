package com.goodforgoodbusiness.kpabe;

public class KPABEException extends Exception {
	public static enum ErrorResult {
		OpenABE_ERROR_INVALID_CONTEXT(2), OpenABE_ERROR_INVALID_CIPHERTEXT(3), OpenABE_ERROR_INVALID_GROUP_PARAMS(4),
		OpenABE_ERROR_INVALID_PARAMS(5), OpenABE_ERROR_INVALID_KEY(6), OpenABE_ERROR_OUT_OF_MEMORY(7),
		OpenABE_ERROR_INVALID_INPUT(8), OpenABE_ERROR_ENCRYPTION_ERROR(9), OpenABE_ERROR_UNKNOWN_SCHEME(10),
		OpenABE_ERROR_LIBRARY_NOT_INITIALIZED(11), OpenABE_ERROR_NO_SECRET_PARAMS(12),
		OpenABE_ERROR_NO_PUBLIC_PARAMS(13), OpenABE_ERROR_NOT_IMPLEMENTED(14), OpenABE_ERROR_BUFFER_TOO_SMALL(15),
		OpenABE_ERROR_WRONG_GROUP(16), OpenABE_ERROR_INVALID_PARAMS_ID(17), OpenABE_ERROR_ELEMENT_NOT_FOUND(18),
		OpenABE_ERROR_SECRET_SHARING_FAILED(19), OpenABE_ERROR_INVALID_POLICY(20), OpenABE_ERROR_INVALID_RNG(21),
		OpenABE_ERROR_SIGNATURE_FAILED(22), OpenABE_ERROR_WRONG_USER_PARAM(23), OpenABE_ERROR_INVALID_LENGTH(24),
		OpenABE_ERROR_SERIALIZATION_FAILED(25), OpenABE_ERROR_INVALID_LIBVERSION(26),
		OpenABE_ERROR_RAND_INSUFFICIENT(27), OpenABE_ERROR_UNEXPECTED_EXTRA_BYTES(28), OpenABE_ERROR_IN_USE_ALREADY(29),
		OpenABE_ERROR_INVALID_KEY_HEADER(30), OpenABE_ERROR_INVALID_CIPHERTEXT_HEADER(31),
		OpenABE_ERROR_DECRYPTION_FAILED(32), OpenABE_ERROR_VERIFICATION_FAILED(33), OpenABE_ERROR_DIVIDE_BY_ZERO(34),
		OpenABE_ERROR_CTR_DRB_NOT_INITIALIZED(35), OpenABE_ERROR_ELEMENT_NOT_INITIALIZED(36),
		OpenABE_ERROR_DESERIALIZATION_FAILED(37), OpenABE_ERROR_INVALID_CURVE_ID(38),
		OpenABE_ERROR_INVALID_SCHEME_ID(39), OpenABE_ERROR_INVALID_KEY_BODY(40),
		OpenABE_ERROR_INVALID_CIPHERTEXT_BODY(41), OpenABE_ERROR_SYNTAX_ERROR_IN_PARSER(42),
		OpenABE_ERROR_CLASS_NOT_INITIALIZED(43), OpenABE_ERROR_INVALID_PACK_TYPE(44),
		OpenABE_ERROR_INVALID_ATTRIBUTE_STRUCTURE(45), OpenABE_ERROR_INDEX_OUT_OF_BOUNDS(46),
		OpenABE_ERROR_MISSING_SENDER_PUBLIC_KEY(47), OpenABE_ERROR_MISSING_RECEIVER_PRIVATE_KEY(48),
		OpenABE_ERROR_MISSING_RECEIVER_PUBLIC_KEY(49), OpenABE_ERROR_MISSING_AUTHORITY_ID_IN_ATTR(50),
		OpenABE_ERROR_INVALID_ATTRIBUTE_LIST(51), OpenABE_ERROR_INVALID_RANGE_NUMBERS(52),
		OpenABE_ERROR_INVALID_MISMATCH_BITS(53), OpenABE_ERROR_INVALID_PREFIX_SPECIFIED(54),
		OpenABE_ERROR_INVALID_DATE_SPECIFIED(55), OpenABE_ERROR_INVALID_DATE_BEFORE_EPOCH(56),
		OpenABE_ERROR_ORDER_NOT_SPECIFIED(57), OpenABE_ERROR_INVALID_POLICY_TREE(58), OpenABE_ERROR_KEYGEN_FAILED(59),
		OpenABE_ERROR_NO_PLAINTEXT_SPECIFIED(60), OpenABE_ERROR_INVALID_TAG_LENGTH(61), OpenABE_ERROR_UNKNOWN(99),
		OpenABE_INVALID_INPUT_TYPE(100), ZCRYPTOBOX_ERROR(1000), DECRYPTION_FAILED(10000),;

		private final int code;
		
		private ErrorResult(int code) {
			this.code = code;
		}
		
		public static ErrorResult get(int code) {
			for (var er : values()) {
				if (er.code == code) {
					return er;
				}
			}
			
			return null;
		}
	}

	public static KPABEException forResult(int code) {
		ErrorResult.DECRYPTION_FAILED.toString();
		
		ErrorResult result = ErrorResult.get(code);
		if (result != null) {
			return new KPABEException("ABE returned error: " + result.name() + " [" + code + "]");
		}
		else {
			return new KPABEException("ABE returned unknown error [" + code + "]");
		}
	}
	
	private KPABEException(String message) {
		super(message);
	}
}
