// /*
//  * This file is part of WebGoat, an Open Web Application Security Project utility. For details, please see http://www.owasp.org/
//  *
//  * Copyright (c) 2002 - 2019 Bruce Mayhew
//  *
//  * This program is free software; you can redistribute it and/or modify it under the terms of the
//  * GNU General Public License as published by the Free Software Foundation; either version 2 of the
//  * License, or (at your option) any later version.
//  *
//  * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
//  * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//  * General Public License for more details.
//  *
//  * You should have received a copy of the GNU General Public License along with this program; if
//  * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
//  * 02111-1307, USA.
//  *
//  * Getting Source ==============
//  *
//  * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software projects.
//  */

// package org.owasp.webgoat.lessons.challenges.challenge5;

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.owasp.webgoat.container.LessonDataSource;
// import org.owasp.webgoat.container.assignments.AssignmentEndpoint;
// import org.owasp.webgoat.container.assignments.AttackResult;
// import org.owasp.webgoat.lessons.challenges.Flags;
// import org.springframework.util.StringUtils;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @Slf4j
// @RequiredArgsConstructor
// public class Assignment5 extends AssignmentEndpoint {

//   private final LessonDataSource dataSource;
//   private final Flags flags;

//   @PostMapping("/challenge/5")
//   @ResponseBody
//   public AttackResult login(
//       @RequestParam String username_login, @RequestParam String password_login) throws Exception {
//     if (!StringUtils.hasText(username_login) || !StringUtils.hasText(password_login)) {
//       return failed(this).feedback("required4").build();
//     }
//     if (!"Larry".equals(username_login)) {
//       return failed(this).feedback("user.not.larry").feedbackArgs(username_login).build();
//     }
//     try (var connection = dataSource.getConnection()) {
//       PreparedStatement statement =
//           connection.prepareStatement(
//               "select password from challenge_users where userid = ? and password = ?");
//       statement.setString(1, username_login);
//       statement.setString(2, password_login);
//       ResultSet resultSet = statement.executeQuery();

//       if (resultSet.next()) {
//         return success(this).feedback("challenge.solved").feedbackArgs(flags.getFlag(5)).build();
//       } else {
//         return failed(this).feedback("challenge.close").build();
//       }
//     }
//   }
// }
