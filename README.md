# File Encryption & Decryption in Java

This project provides a simple way to encrypt and decrypt files using the **AES encryption algorithm** in Java.

## Features
- Encrypt a file with AES encryption
- Generate a secure encryption key
- Decrypt a file using the provided key
- Save encrypted and decrypted files

## Prerequisites
- **Java JDK 17 or later** (JDK 21 recommended)

## How to Compile and Run

### 1. Compile the Program
```sh
javac FileEncryption.java
```

### 2. Run the Program
```sh
java FileEncryption
```

## Usage
1. Select an option:
   - `1` for **Encryption**
   - `2` for **Decryption**
2. Provide the file path.
3. (For encryption) Save the generated key securely.
4. (For decryption) Enter the previously saved key.

## Example
### Encryption
```
Choose an option:
1. Encrypt a file
2. Decrypt a file
Enter choice: 1
Enter the path of the file to encrypt: example.txt
Enter name for encrypted file: encrypted.dat
File encrypted and saved as: encrypted.dat
Encryption Key: <your-key>
```

### Decryption
```
Choose an option:
1. Encrypt a file
2. Decrypt a file
Enter choice: 2
Enter the path of the file to decrypt: encrypted.dat
Enter the key for decryption: <your-key>
Enter name for decrypted file: decrypted.txt
File decrypted and saved as: decrypted.txt
```

## Important Notes
- **Save your encryption key** after encryption; otherwise, you won't be able to decrypt the file.
- Ensure that the file paths are correct when providing input.
- The program uses **AES (Advanced Encryption Standard) with a 256-bit key**.
- test1.txt is the encrypted file
- test1_res.txt is the decrypted file

## License
This project is open-source and available for free use.

