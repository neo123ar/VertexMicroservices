package eu.dreamix.eu.dreamix.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.IOUtils;

/**
 * Created by G515133 on 18/12/2017.
 */
public class SeMatcher {

    private static final String FILE_NAME = "D://securityevent//se_log.js";

    public static void main(String[] args) throws IOException {


        List<String> ref_se_01 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_02 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:MobileOneFactorContract][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:MobileOneFactorContract][F1:0][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:PreviousSession][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_03 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FALLBACK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport][F1:5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_04 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:CANCELED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_05 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:051178a75f809ce98661e6cad1c065c97e21b310d49cce628f893b8b940bfb28][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_06 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_TEST_UNKNOWN][LO:][PH:REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_07 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_TEST][LO:USER_TEST_UNKNOWN][PH:REQUEST][ST:UNKNOWN_USER][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_09 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:LOGOUT_REQUEST][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_10 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_08 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:AlwaysYes][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> ref_se_11 = new ArrayList<String>(Arrays.asList("[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:a7decb4daa108e6fd47de79983d1b8c1b530e9e58ffb0a3cd19503ee45f8db80][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:3c5fdd9ec00684bc2c590122cefa94b4696124474d8f8a919a62737c4614cc24][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:LOCKED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:0c8f0fc31e751cbc62c3602bc61c1df7db6774d1fdbec4657f99bbda977be62e][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));

        List ref_se_12 = new ArrayList();

        List<String> se_01 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01ef4fd32d0ed34283a55fff934aa3dc0822][RT:2017-12-13T18:32:20,645Z][AT:2017-12-13T18:32:20,645Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01ef4fd32d0ed34283a55fff934aa3dc0822][RT:2017-12-13T18:32:20,645Z][AT:2017-12-13T18:32:23,762Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_02 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01628680a5bcb0415581f3543fd68b973d22][RT:2017-12-13T18:32:36,471Z][AT:2017-12-13T18:32:36,471Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:MobileOneFactorContract][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01628680a5bcb0415581f3543fd68b973d22][RT:2017-12-13T18:32:36,471Z][AT:2017-12-13T18:32:37,002Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:MobileOneFactorContract][F1:0][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01a617cd4db0af4eafb3c0f62f8fbdceef22][RT:2017-12-13T18:32:38,134Z][AT:2017-12-13T18:32:38,134Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:PreviousSession][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_03 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01b81e6c612873449f9186ea827ac3e15a22][RT:2017-12-13T18:32:44,062Z][AT:2017-12-13T18:32:44,062Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01b81e6c612873449f9186ea827ac3e15a22][RT:2017-12-13T18:32:44,062Z][AT:2017-12-13T18:32:44,496Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FALLBACK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01b81e6c612873449f9186ea827ac3e15a22][RT:2017-12-13T18:32:44,062Z][AT:2017-12-13T18:32:44,775Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport][F1:5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_04 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS014a4e50f359cb49fb85a9cb8d634c340222][RT:2017-12-13T18:32:49,936Z][AT:2017-12-13T18:32:49,936Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS014a4e50f359cb49fb85a9cb8d634c340222][RT:2017-12-13T18:32:49,936Z][AT:2017-12-13T18:32:50,274Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:CANCELED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_05 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01a587636acd804a0bb87c9734da974c8922][RT:2017-12-13T18:32:55,533Z][AT:2017-12-13T18:32:55,533Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01a587636acd804a0bb87c9734da974c8922][RT:2017-12-13T18:32:55,533Z][AT:2017-12-13T18:32:55,796Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:051178a75f809ce98661e6cad1c065c97e21b310d49cce628f893b8b940bfb28][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01a587636acd804a0bb87c9734da974c8922][RT:2017-12-13T18:32:55,533Z][AT:2017-12-13T18:32:56,030Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_06 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:dacs04db5ebe82a94a6a84f1ccaba12b9aa1][RT:2017-12-13T18:33:00,847Z][AT:2017-12-13T18:33:00,847Z][IP:127.0.0.1][AP:APPLICATION_TEST_UNKNOWN][LO:][PH:REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_07 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS018f91f871bfdb4e42b74a04916556f62222][RT:2017-12-13T18:33:05,838Z][AT:2017-12-13T18:33:05,838Z][IP:127.0.0.1][AP:APPLICATION_TEST][LO:USER_TEST_UNKNOWN][PH:REQUEST][ST:UNKNOWN_USER][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_08 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01ea344e118317401fa837014ebb60fa3222][RT:2017-12-13T18:33:10,783Z][AT:2017-12-13T18:33:10,783Z][IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:AlwaysYes][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01ea344e118317401fa837014ebb60fa3222][RT:2017-12-13T18:33:10,783Z][AT:2017-12-13T18:33:11,158Z][IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01ea344e118317401fa837014ebb60fa3222][RT:2017-12-13T18:33:10,783Z][AT:2017-12-13T18:33:11,271Z][IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01ea344e118317401fa837014ebb60fa3222][RT:2017-12-13T18:33:10,783Z][AT:2017-12-13T18:33:11,442Z][IP:127.0.0.1][AP:APPLICATION_TEST_ENROLLMENT_PRE_POST][LO:USER_ENROLL][PH:ENROLLMENT][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_09 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS01bfcd4884d83b45ae80f81efbb6be9a8922][RT:2017-12-13T18:33:17,205Z][AT:2017-12-13T18:33:17,205Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01bfcd4884d83b45ae80f81efbb6be9a8922][RT:2017-12-13T18:33:17,205Z][AT:2017-12-13T18:33:17,474Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:dacs2b02c243868d411daa7352168428804a][RT:2017-12-13T18:33:18,342Z][AT:2017-12-13T18:33:18,342Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:LOGOUT_REQUEST][ST:OK][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01ec8161ec150d4a8a9796f7e46787fb5922][RT:2017-12-13T18:33:18,434Z][AT:2017-12-13T18:33:18,434Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List<String> se_10 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:dacs099122bdd22b4a63af73d0095da6a44c][RT:2017-12-13T18:33:22,333Z][AT:2017-12-13T18:33:22,333Z][IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01de09ce89be16476da13629ccc30d87f522][RT:2017-12-13T18:33:22,426Z][AT:2017-12-13T18:33:22,426Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS01de09ce89be16476da13629ccc30d87f522][RT:2017-12-13T18:33:22,426Z][AT:2017-12-13T18:33:22,682Z][IP:127.0.0.1][AP:APPLICATION_REST_LOGOUT_TEST_01][LO:TEST_LOGOUT_1][PH:AUTHENTICATION][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:495ac5d03abc7e2812998371d1c9d8f802f1995fe9ab2135a30578852add5c44][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:dacs1645d58ba3744707a3051ec069eb8927][RT:2017-12-13T18:33:23,271Z][AT:2017-12-13T18:33:23,271Z][IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:dacs6c9c9b604c2449e2a186556887f71dea][RT:2017-12-13T18:33:23,365Z][AT:2017-12-13T18:33:23,365Z][IP:127.0.0.1][AP:][LO:][PH:LOGOUT_REQUEST][ST:REQUEST_ERROR][FT:][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));

        List<String> se_11 = new ArrayList<String>(Arrays.asList("[Dictao_Dac][ID:CtxDACS0140f20eec5f7d402dbdc2f2b449f4ded622][RT:2017-12-13T18:33:27,156Z][AT:2017-12-13T18:33:27,156Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:REQUEST][ST:OK][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS0140f20eec5f7d402dbdc2f2b449f4ded622][RT:2017-12-13T18:33:27,156Z][AT:2017-12-13T18:33:27,419Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:a7decb4daa108e6fd47de79983d1b8c1b530e9e58ffb0a3cd19503ee45f8db80][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS0140f20eec5f7d402dbdc2f2b449f4ded622][RT:2017-12-13T18:33:27,156Z][AT:2017-12-13T18:33:27,648Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:FAILED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:3c5fdd9ec00684bc2c590122cefa94b4696124474d8f8a919a62737c4614cc24][F2:][F3:][F4:][F5:][F6:][F7:][F8:]", "[Dictao_Dac][ID:CtxDACS0140f20eec5f7d402dbdc2f2b449f4ded622][RT:2017-12-13T18:33:27,156Z][AT:2017-12-13T18:33:27,866Z][IP:127.0.0.1][AP:APPLICATION_REST_TEST][LO:TEST_REST_USER][PH:AUTHENTICATION][ST:LOCKED][FT:urn:dictao:dacs:ac:classes:Birthdate][F1:0c8f0fc31e751cbc62c3602bc61c1df7db6774d1fdbec4657f99bbda977be62e][F2:][F3:][F4:][F5:][F6:][F7:][F8:]"));
        List se_12 = new ArrayList();

        List allArrays = new ArrayList();
        allArrays.add(ref_se_01);
        allArrays.add(ref_se_02);
        allArrays.add(ref_se_03);
        allArrays.add(ref_se_04);
        allArrays.add(ref_se_05);
        allArrays.add(ref_se_06);
        allArrays.add(ref_se_07);
        allArrays.add(ref_se_08);
        allArrays.add(ref_se_09);
        allArrays.add(ref_se_10);
        allArrays.add(ref_se_11);
        allArrays.add(ref_se_12);

        List seArrays = new ArrayList();


        File src = new File("D:/securityevent/se_log.js");
        String content = IOUtils.toString(new FileInputStream(FILE_NAME),"UTF-8");
        String[] tmpArray = content.split(";\n");
        for (int i = 0; i < tmpArray.length; i++) {

            tmpArray[i] = tmpArray[i].substring(tmpArray[i].indexOf(" = [")).replaceAll("\n","").substring(5);
            if (tmpArray[i].length() > 3) {
                String[] tmpValues = tmpArray[i].substring(0, tmpArray[i].length() - 3).split("\',\'");
                List seList = new ArrayList();
                for (String value : tmpValues) {
                    seList.add(value);
                }

                seArrays.add(seList);

            } else {
                List seList = new ArrayList();
                seList.add(tmpArray[i]);
                seArrays.add(seList);
            }


        }

        Map results = new HashMap();
        SeMatcher matcher = new SeMatcher();
        matcher.parse_se_log(allArrays,seArrays,results);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }




    }

    public void parse_se_log(List allArrays, List seArrays, Map results) {
        for (int i = 0; i < allArrays.size(); i++) {
            if (i == 1) {
                parseSe_02((List)allArrays.get(i), (List)seArrays.get(i), results, i);
            } else if (i == 8) {
                parseSe_09((List)allArrays.get(i), (List)seArrays.get(i), results, i);
            } else if (i == 9) {
                parseSe_10((List)allArrays.get(i), (List)seArrays.get(i), results, i);
            } else if (i == 11) {
                parseSe_12((List)allArrays.get(i), (List)seArrays.get(i), results, i);
            } else {
                parseSeLog((List)allArrays.get(i), (List)seArrays.get(i), results, ((List)allArrays.get(i)).size(),i);
            }

        }


    }

    public void parseSe_02(List ref, List se, Map results, int i) {
        if (se.size() != ref.size()) {
            results.put(i, 0);
            return;

        }


        List firstrequest = new ArrayList();
        firstrequest.add(se.get(0));
        firstrequest.add(se.get(1));
        parseSeLog(ref, firstrequest, results, 2, i);
        Object line_data =  se.get(2).toString().substring(se.get(2).toString().indexOf("[IP:"));
        if (results.get(i).equals(1) && !ref.get(2).equals(line_data)) {
            results.put(i , "0");
            return;

        }

    }

    public void parseSe_09(List ref, List se, Map results, int i) {
        if (se.size() != ref.size()) {
            results.put(i , 0);
            return;

        }


        List firstrequest = new ArrayList();
        firstrequest.add(se.get(0));
        firstrequest.add(se.get(1));
        parseSeLog(ref, firstrequest, results, 2, i);
        Object line_data =  se.get(2).toString().substring(se.get(2).toString().indexOf("[IP:"));
        if (results.get(i).equals(1) && !ref.get(2).equals(line_data)) {
            results.put(i , "0");
            return;

        }

        line_data =  se.get(3).toString().substring(se.get(3).toString().indexOf("[IP:"));
        if (results.get(i ).equals(1) && !ref.get(3).equals(line_data)) {
            results.put(i , "0");
            return;

        }

    }

    public void parseSe_10(List ref, List se, Map results, int i) {
        if (se.size() != ref.size()) {
            results.put(i , 0);
            return;

        }


        List request = new ArrayList();
        request.add(se.get(1));
        request.add(se.get(2));
        List requestRef = new ArrayList();
        requestRef.add(ref.get(1));
        requestRef.add(ref.get(2));
        parseSeLog(requestRef, request, results, 2, i);
        Object line_data = se.get(3).toString().substring(se.get(3).toString().indexOf("[IP:"));
        if (results.get(i).equals(1) && !ref.get(3).equals(line_data)) {
            results.put(i , "0");
            return;

        }

        line_data = se.get(4).toString().substring(se.get(4).toString().indexOf("[IP:"));
        if (results.get(i).equals(1) && !ref.get(4).equals(line_data)) {
            results.put(i , "0");
            return;

        }

    }

    public void parseSe_12(List ref, List se, Map results, int i) {
        if ( se.size() ==0 || (se.size()== 1 && se.get(0).toString().isEmpty())) {
            results.put(i , 1);

        }
        else {
            results.put(i, 0);
        }
        return ;
    }

    public void parseSeLog(List ref, List se, Map results, int nbLines, int i) {
        if (se.size() != nbLines) {
            results.put(i , 0);
            return;

        }

        if (!verifyRTAndATAndID(se, nbLines)) {
            results.put(i , 0);
            return;

        }


        for (int j = 0; j < nbLines; j++) {
            String line_data = se.get(j).toString().substring(se.get(j).toString().indexOf("[IP:"));
            if (!ref.get(j).equals(line_data) ) {
                results.put(i, 0);
                return;

            }

        }

        results.put(i, 1);
    }

    public boolean verifyRTAndATAndID(List se, int nbLines) {
        List timeList = new ArrayList();
        List idList = new ArrayList();
        for (int i = 0; i < nbLines; i++) {

        String[] line_tags = se.get(i).toString().split("]\\[");    if (i == 0) {
                timeList.add(getAt(line_tags[3]));
            }

            timeList.add(getRt(line_tags[2]));
            idList.add(getId(line_tags[1]));
        }

        Object timeValue = timeList.get(0);

        for (int i = 0; i < timeList.size(); i++) {
            if (!timeValue.equals(timeList.get(i))) {
                return false;
            }

        }

        Object idValue = idList.get(0);
        for (int i = 0; i < idList.size(); i++) {
            if (!idValue.equals(idList.get(i))) {
                return false;
            }

        }

        return true;
    }

    public String getRt(String tag) {
        return tag.substring(3);
    }

    public String getAt(String tag) {
        return tag.substring(3);
    }

    public String getId(String tag) {
        return tag.substring(3);
    }


}


