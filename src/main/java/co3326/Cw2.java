package co3326;

import java.util.List;

public class Cw2 {

	protected User A;
	protected User B;
	protected User S;
	protected List<Message> communication;
    
    public Cw2() {}
            
    public void demonstrate() {
		/*
		 * TODO Implement the protocol of authentication between Alice and Bob
		 * using a trusted Server:
		 * 
    	 * 1) Dear S, This is A and I would like to get B-s public key. Yours sincerely, A.        
    	 * 2) Dear A, Here is B-s public key signed by me. Yours sincerely, S.
    	 * 3) Dear B, This is A and I have sent you a nonce [111] only you can read. Yours sincerely, A.
    	 * 4) Dear S, This is B and I would like to get A-s public key. Yours sincerely, B.
    	 * 5) Dear B, Here is A-s public key signed by me. Yours sincerely, S.
    	 * 6) Dear A, Here is my nonce [222] and yours [111], proving I decrypted it. Yours sincerely, B.
    	 * 7) Dear B, Here is your nonce [222] proving I decrypted it. Yours sincerely, A.
    	 * 
    	 * Replace 111 and 222 with the actual nonces that you're given or that you generate.
    	 * Encrypt the relevant messages (apart from 1 and 4), according to the description 
    	 * provided using the appropriate key.
    	 * 
    	 * Make sure that the <i>communication</i> contains these 7 messages. 1 and 4 will have to 
    	 * have the <i>text</i> and the <i>encoded</i> fields set; the rest will also need to have the
    	 * <i>encrypted</i> field set. See the examples provided.  
         */
    }

}

