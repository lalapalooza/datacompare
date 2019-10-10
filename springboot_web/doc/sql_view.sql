create view table_status as
select config.id as tid,config.task_name, logger.* from table_config as config
left join table_logger as logger
on logger.table_id=config.id
and logger.id in(select max(id) as id from table_logger where start_date>DATE_ADD(NOW(),INTERVAL -1 MONTH)
group by table_id)