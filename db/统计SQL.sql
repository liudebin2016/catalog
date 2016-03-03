--域的查询
select 
  c.id, c.firstDomain || '/' || c.secondDomain as demain
from 
  (select 
        o.id,o.parent_id,o.name as secondDomain,s.name as firstDomain
   from 
        SYS_OFFICE o,(select t.name, t.id from SYS_OFFICE t where t.parent_id = 0) s
   where 
        o.parent_id = s.id
  ) c;
 
--机构的查询
select d.id,e.demain,d.name as officeName from SYS_OFFICE d ,
(select 
  c.id, c.firstDomain || '/' || c.secondDomain as demain
from 
  (select 
        o.id,o.parent_id,o.name as secondDomain,s.name as firstDomain
   from 
        SYS_OFFICE o,(select t.name, t.id from SYS_OFFICE t where t.parent_id = 0) s
   where 
        o.parent_id = s.id
  ) c) e
  where e.id=d.parent_id
  union
  select h.id,h.demain,h.firstOffice||'/'||h.secondOffice as officeName from (
 select f.id,f.name as secondOffice,f.parent_id,g.firstOffice,g.demain from  SYS_OFFICE f,
  (select d.id,d.name as firstOffice,d.parent_id,e.demain from SYS_OFFICE d ,
(select 
  c.id, c.firstDomain || '/' || c.secondDomain as demain
from 
  (select 
        o.id,o.parent_id,o.name as secondDomain,s.name as firstDomain
   from 
        SYS_OFFICE o,(select t.name, t.id from SYS_OFFICE t where t.parent_id = 0) s
   where 
        o.parent_id = s.id
  ) c) e
  where e.id=d.parent_id)g
  where g.id=f.parent_id)h
  