@PostMapping("/SqlOnlyInputValidation/insecureAttack")
@ResponseBody
public AttackResult insecureAttack(@RequestParam("userid_insecure") String userId) {
  try {
    // Directly concatenating user input into the query (vulnerable to SQL injection)
    String query = "SELECT * FROM users WHERE userid = '" + userId + "'";
    // Execute the query (this is a placeholder, actual execution logic would depend on your setup)
    String result = lesson6a.executeQuery(query); // Hypothetical method for executing the query
    return success(this).feedback("SqlOnlyInputValidation-success").output(result).build();
  } catch (Exception e) {
    return failed(this).feedback("SqlOnlyInputValidation-error").output(e.getMessage()).build();
  }
}
