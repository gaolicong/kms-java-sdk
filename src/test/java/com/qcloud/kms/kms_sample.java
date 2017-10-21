package com.qcloud.kms;

import java.util.ArrayList;

/**
 * @file kms_sample.java
 * @author:yorkxyzhang
 * @Description:kms sample
 * @date :2017-2-28
 **/
public class kms_sample {
    public static void main(String[] args) {
        // 从腾讯云官网查询的云API密钥信息
        String secretId = "AKIDlR0NYWUsJdnGaixR3ThjaFhx1ubp3S9e";
        String secretKey = "X2LSXQBk7hJTTIuVu78VmrkQIZwHcw40";
        String endpoint = "https://kms-gz.api.qcloud.com";
        KMSAccount account = new KMSAccount(endpoint, secretId, secretKey);
        String Description = "test";
        String Alias = "test4";
        String KeyUsage = "ENCRYPT/DECRYPT";
        KeyMetadata meta = null;
        try {
            /*meta = account.create_key(Description, Alias, KeyUsage);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            /*System.out.println("------------create the custom master key-------------");
            System.out.println("KeyId               " + meta.KeyId);
            System.out.println("CreateTime          " + Integer.toString(meta.CreateTime));
            System.out.println("Description         " + meta.KeyId);
            System.out.println("KeyState            " + meta.KeyState);
            System.out.println("KeyUsage            " + meta.KeyUsage);
            System.out.println("Alias               " + meta.Alias);*/

            // create a data key
            /*String keyid = "kms-mop3d79j";
            String KeySpec = "AES_128";
            String Plaintext = "你好";
            String CiphertextBlob = account.generate_data_key(keyid, KeySpec, 128, "{\"g\":\"c\"}", Plaintext);
            System.out.println("the data key string is " + Plaintext);
            System.out.println("the encrypted data key string is " + CiphertextBlob);*/

            // encrypt the data key
            /*String keyid = "kms-mop3d79j";
            String Plaintext = "你好";
            String CiphertextBlob = account.encrypt(keyid, Plaintext, "{\"g\":\"c\"}");
            System.out.println("the encrypted data is " + CiphertextBlob);*/

            // decrypt the encrypted data string
            String keyid = "kms-mop3d79j";
            String CiphertextBlob = "a21zLW1vcDNkNzlqAAAAAAAAAAA=98g23kiWPWuHoA7OqW5pCQBBe/GmkJzSaqd+Hy6thQL1y+jAGd1z0sGSUFZXvaP7e4oX7stima6gWOrwQ04gYEGMMDTPFCoel2HTWvdAPDQmxJSCpywF/6X6KkuyqQqBgqhY6QQ14FnLREgpGdofYMMfT5XWgUwxWhCrMyoxYYTUh/Pab01pewfPc+4ZZHS6arYokndEQ+dRuFdHIYVdWP/iCrRH8HpAYwz+7JZLowTAXlAQ==";
            String Plaintext = account.decrypt(CiphertextBlob, "{\"g\":\"c\"}");
            System.out.println("the decrypted data is " + Plaintext);

            // get the key attributes
            /*meta = account.get_key_attributes(keyid);

            System.out.println("------------create the custom master key-------------");
            System.out.println("KeyId               " + meta.KeyId);
            System.out.println("CreateTime          " + Integer.toString(meta.CreateTime));
            System.out.println("Description         " + meta.KeyId);
            System.out.println("KeyState            " + meta.KeyState);
            System.out.println("KeyUsage            " + meta.KeyUsage);
            System.out.println("Alias               " + meta.Alias);*/

            // set alias
            /*Alias = "for test";
            account.set_key_attributes(meta.KeyId, Alias);

            // disable a custom key
            account.disable_key(meta.KeyId);

            // enable a custom key
            account.enable_key(meta.KeyId);*/

            // schedule delete key
            // account.schedule_key_deletion(meta.KeyId,7);
            // cancel delete key
            // account.cancel_key_deletion(meta.KeyId);

            // list keys
           /* ArrayList<String> KeyId = new ArrayList<String>();
            account.list_key(-1, -1, KeyId);
            for (int i = 0; i < KeyId.size(); ++i)
                System.out.println("the " + Integer.toString(i) + "Key id is " + KeyId.get(i));*/

        } catch (KMSServerException e1) {
            System.out.println("Server Exception, " + e1.toString());
        } catch (KMSClientException e2) {
            System.out.println("Client Exception, " + e2.toString());
        } catch (Exception e) {
            System.out.println("error..." + e.toString());
        }

    }
}
