SELECT 
	so.name as region,brj.name as office,brj.duty as ofcDuty,brj.bCount as bizCount,brj.rCount as rscCount,brj.jCount as jobCount  
FROM 
	sys_office so ,(
	SELECT 
		tbr.*,count(j.office_id) as jCount 
	FROM 
		(
			SELECT 
				tb.*,count(r.response_party) as rCount 
			FROM 
				(
					SELECT 
						o.id,o.`name`,o.parent_id,o.parent_ids,o.duty,COUNT(b.charge_office_id) as bCount 
					FROM 
						sys_office o 
					LEFT JOIN 
						business b 
					ON 
						b.charge_office_id=o.id 
					GROUP BY 
						o.id
				) tb
			LEFT JOIN 
				resource_info r 
			ON 
				r.response_party=tb.id 
			GROUP BY 
				tb.id
		) tbr 
	LEFT JOIN 
		job j 
	ON 
		tbr.id=j.office_id 
	GROUP BY 
		tbr.id
	) brj 
WHERE 
	brj.parent_id=so.id
	
	
	
	
	
	
	
	
SELECT count(r.keyword) kwCount from rpt_search r GROUP BY r.keyword ORDER BY kwCount desc;

SELECT count(r.keyword) kwCount from rpt_search r where r.srhType=1 GROUP BY r.keyword ORDER BY kwCount desc;
