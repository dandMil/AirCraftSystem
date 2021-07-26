# AirCraftSystem
Using a PriorityQueue to automatically keep the natural ordering within a set


GET

localhost:8080/getAll/

output example:

AirCraft{type='passenger', size='large', id='69f49df9-91c2-4127-9ff0-30167678271b'}
----------------
AirCraft{type='cargo', size='small', id='88931b83-1111-462e-99f1-ca0308fc3fc8'}
----------------
AirCraft{type='cargo', size='large', id='19beed30-190f-413f-86e3-0feae4c50f9d'}
----------------


----------------------------------------




POST

localhost:8080/create/

payload example:

{
	"type":"cargo",
	"size":"small"
}



sample output:


AirCraft{type='passenger', size='large', id='69f49df9-91c2-4127-9ff0-30167678271b'}
----------------
AirCraft{type='cargo', size='small', id='88931b83-1111-462e-99f1-ca0308fc3fc8'}
----------------
AirCraft{type='cargo', size='large', id='19beed30-190f-413f-86e3-0feae4c50f9d'}
----------------

----------------------------------------





DELETE

localhost:8080/delete/

output example (first record will be deleted):

AirCraft{type='cargo', size='small', id='88931b83-1111-462e-99f1-ca0308fc3fc8'}
----------------
AirCraft{type='cargo', size='large', id='19beed30-190f-413f-86e3-0feae4c50f9d'}
----------------


----------------------------------------





PUT

localhost:8080/boot/?status=off
localhost:8080/boot/?status=on

sample output:
AirCraftQueue is online

----------------------------------------
