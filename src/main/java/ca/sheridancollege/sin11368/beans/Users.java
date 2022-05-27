package ca.sheridancollege.sin11368.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

	private long userID;
	private String userName;
	private String encryptedPassword;
}
