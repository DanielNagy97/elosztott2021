package iit.uni.RedisExample;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("people")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {
	@Id
	private String id;
	private String firstname;
	private String lastname;
}
