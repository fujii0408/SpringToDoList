package todo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreateHashedPassword {

//	パスワードのハッシュ値を生成
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = bCryptPasswordEncoder.encode("1234"); //""の中に生のパスワードを入力

		System.out.println(hashedPassword);
	}

}
