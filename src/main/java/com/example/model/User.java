package com.example.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Set;

/** created by pengmingguo on 2/8/18 */
@Entity
@Table(
        name = "t_user"
)
@Getter
@Setter
public class User  implements Serializable {

    // 用户角色
    public static String ADMIN = "admin";
    public static String MEMBER = "member";

    // 用户 状态码
    public static int INVITED = 1;
    public static int ACTIVATED = 2;

    @Length(min = 1, max = 100)
    private String name;

    @Email private String email;

    @Length(min = 8, max = 50)
    private String password;

    @Column(name = "invite_id")
    private String inviteId;

    @ManyToOne
    @JoinColumn(name = "parent")
    private User parent;

    @OneToMany(mappedBy = "parent")
    private Collection<User> children;

    private String role;

    @Column(columnDefinition = "TINYINT")
    private Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), email);
    }
}
