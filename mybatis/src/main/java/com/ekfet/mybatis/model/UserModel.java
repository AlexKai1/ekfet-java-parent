package com.ekfet.mybatis.model;

import java.io.Serializable;

public class UserModel implements Serializable {

  private static final long serialVersionUID = -4460985200653286472L;
  private Long userId; // 用户记录id,雪花算法生成
  private Integer uid; // 用户uid唯一
  private String nickname; // 昵称
  private String userName; // 姓名
  private Integer userSex; // 性别 0男 1女
  private String telephone; // 手机号
  private String openId; // open_id
  private String zfbUserId; // 支付宝user_id
  private String loginName; // 用户名
  private String pwd; // 密码
  private String salt; // 盐值
  private String headPic; // 头像
  private String email; // 邮箱
  private Integer idCardType; // 证件类型 1身份证、2居住证、3签证、4护照、5户口本、6军人证、7港澳通行证、8其它
  private String idCardCode; // 证件号
  private String inviteCode; // 邀请码
  private String address; // 地址
  private String lastIp; // 最后一次登陆ip
  private Integer isEffect; // 是否生效 0否 1是
  private Integer isDel; // 是否删除 0否 1是
  private Integer isLocked; // 是否锁定 0否 1是
  private Integer isBlack; // 是否黑名单 0否 1是
  @Deprecated private Long parentId; // 父类ID，上级id
  @Deprecated private Long referrerId; // 推荐人id
  @Deprecated private Long leftId; // 左节点id
  @Deprecated private Long rightId; // 右节点id
  private Integer isMch; // 是否商户 0否 1是
  private Integer roleId; // 用户角色Id
  private Integer sourceId; // 用户来源 1 web 2 app 3 其它
  private Integer groupId;
  private java.util.Date createTime; // 创建时间
  private java.util.Date modifyTime; // 修改时间

  // 以下字段不需要持久化DB
  private String securityCode; // 交易密码
  private String roleName;
  private String referrName; // 推荐人名称
  private Integer referrerUid; // 推荐人Uid
  private String referrerTelephone; // 推荐人手机号

  public String getReferrerTelephone() {
    return referrerTelephone;
  }

  public void setReferrerTelephone(String referrerTelephone) {
    this.referrerTelephone = referrerTelephone;
  }

  public Integer getReferrerUid() {
    return referrerUid;
  }

  public void setReferrerUid(Integer referrerUid) {
    this.referrerUid = referrerUid;
  }

  public String getReferrName() {
    return referrName;
  }

  public void setReferrName(String referrName) {
    this.referrName = referrName;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getUid() {
    return this.uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getUserSex() {
    return this.userSex;
  }

  public void setUserSex(Integer userSex) {
    this.userSex = userSex;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getZfbUserId() {
    return this.zfbUserId;
  }

  public void setZfbUserId(String zfbUserId) {
    this.zfbUserId = zfbUserId;
  }

  public String getLoginName() {
    return this.loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPwd() {
    return this.pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getHeadPic() {
    return this.headPic;
  }

  public void setHeadPic(String headPic) {
    this.headPic = headPic;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getIdCardType() {
    return this.idCardType;
  }

  public void setIdCardType(Integer idCardType) {
    this.idCardType = idCardType;
  }

  public String getIdCardCode() {
    return this.idCardCode;
  }

  public void setIdCardCode(String idCardCode) {
    this.idCardCode = idCardCode;
  }

  public String getInviteCode() {
    return this.inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLastIp() {
    return this.lastIp;
  }

  public void setLastIp(String lastIp) {
    this.lastIp = lastIp;
  }

  public Integer getIsEffect() {
    return this.isEffect;
  }

  public void setIsEffect(Integer isEffect) {
    this.isEffect = isEffect;
  }

  public Integer getIsDel() {
    return this.isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }

  public Integer getIsLocked() {
    return this.isLocked;
  }

  public void setIsLocked(Integer isLocked) {
    this.isLocked = isLocked;
  }

  public Integer getIsBlack() {
    return this.isBlack;
  }

  public void setIsBlack(Integer isBlack) {
    this.isBlack = isBlack;
  }

  public Long getParentId() {
    return this.parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public Long getReferrerId() {
    return this.referrerId;
  }

  public void setReferrerId(Long referrerId) {
    this.referrerId = referrerId;
  }

  public Long getLeftId() {
    return this.leftId;
  }

  public void setLeftId(Long leftId) {
    this.leftId = leftId;
  }

  public Long getRightId() {
    return this.rightId;
  }

  public void setRightId(Long rightId) {
    this.rightId = rightId;
  }

  public Integer getIsMch() {
    return this.isMch;
  }

  public void setIsMch(Integer isMch) {
    this.isMch = isMch;
  }

  public Integer getRoleId() {
    return this.roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Integer getSourceId() {
    return this.sourceId;
  }

  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  public Integer getGroupId() {
    return groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public java.util.Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(java.util.Date createTime) {
    this.createTime = createTime;
  }

  public java.util.Date getModifyTime() {
    return this.modifyTime;
  }

  public void setModifyTime(java.util.Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
