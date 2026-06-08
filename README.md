複合查詢->我昨天and今天遇到的BUG+重點整理(先說我是Hibernate)

1. 記得把table要加到hibernate.cfg.xml，沒加會跳錯誤（找不到DB Table）
2. 我是三個TABLE <Admin><AdmPer><AdmFunc>
<Admin>會可能有2個或以上權限 所以AdmPer是另外2個的中介表
3. 在AdmPerVO插入2邊的VO還有是Join什麼 + **Setter+Getter**

```java
 @ManyToOne
 @JoinColumn(name = "ADM_ID") // FK ->ADMIN 的ADM_ID
 private AdminVO adminVO; //在Java他生在AdminVO
 
 @ManyToOne
 @JoinColumn(name = "FUNC_ID")//FK ->ADM_FUNCTION的FUNC_ID
 private AdmFuncVO admfuncVO;
```

---

1. AdminVO 需要加入 FK的資訊 
// ------------------FK
`@OneToMany(mappedBy = "adminVO", fetch = FetchType.EAGER)
private Set<AdmPerVO> admPerVO;`
// -----------------FK
然後他們是需要用Setter + Getter//一鍵生成
2. AdmFuncVO 需要加入 FK的資訊
// ------------------FK
`@OneToMany(mappedBy = "AdmFuncVO", fetch = FetchType.EAGER)
private Set<AdmPerVO> admPerVOs;`
// -----------------FK
然後他們是需要用Setter + Getter//一鍵生成
