package com.laom.medic.rest.auth;

import com.laom.medic.jpa.entities.Usuarios;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException; 
import java.util.Arrays;
import org.joda.time.DateTime;

public final class AuthUtils {

    private static final JWSHeader JWT_HEADER = new JWSHeader(JWSAlgorithm.HS256);
    private static final String TOKEN_SECRET = "adsiinwonderland**";
    public static final String AUTH_HEADER_KEY = "Authorization";

    public static String getSubject(String authHeader) throws ParseException, JOSEException {
        return decodeToken(authHeader).getSubject();
    }

    public static ReadOnlyJWTClaimsSet decodeToken(String authHeader) throws ParseException, JOSEException {
        SignedJWT signedJWT = SignedJWT.parse(getSerializedToken(authHeader));
        if (signedJWT.verify(new MACVerifier(TOKEN_SECRET))) {
            return signedJWT.getJWTClaimsSet();
        } else {
            throw new JOSEException("Signature verification failed");
        }
    }

    public static Token createToken(String host, Usuarios user) throws JOSEException {
        JWTClaimsSet claim = new JWTClaimsSet();
        claim.setSubject(Integer.toString(user.getIdUsuario()));
        claim.setIssuer(host);
        claim.setIssueTime(DateTime.now().toDate());
        claim.setExpirationTime(DateTime.now().plusDays(1).toDate());
        claim.setCustomClaim("id", user.getIdUsuario());
        claim.setCustomClaim("identificacion", user.getIdIdentificacion());
        claim.setCustomClaim("user", user.getPrimerNombre() + " " + user.getPrimerApellido());
        claim.setCustomClaim("roles", Arrays.toString(user.getRolesList().toArray()));
        claim.setCustomClaim("sedes", Arrays.toString(user.getSedesList().toArray()));

        JWSSigner signer = new MACSigner(TOKEN_SECRET);
        SignedJWT jwt = new SignedJWT(JWT_HEADER, claim);
        jwt.sign(signer);

        return new Token(jwt.serialize());
    }

    public static String getSerializedToken(String authHeader) {
        return authHeader.split(" ")[1];
    }
}
